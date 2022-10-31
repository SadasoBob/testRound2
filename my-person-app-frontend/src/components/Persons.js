import React, { useState, useEffect } from 'react';

export function PersonsComponent() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [persons, setItems] = useState([]);
  
    useEffect(() => {

      fetch("http://localhost:8082/persons") // ?page=numero de page pour chercher une autre page
        .then(res => res.json())
        .then(
          (result) => {
            setIsLoaded(true);
            setItems(result.content);
          },

          (error) => {
            setIsLoaded(true);
            setError(error);
          }
        )
    }, [])
  
    if (error) {
      return <tr><td>Error: {error.message}</td></tr>;
    } else if (!isLoaded) {
      return <tr><td>Loading...</td></tr>;
    } else {
      return (
            persons.map(person => 
            <tr key={person.id}>
                <td>{person.prenom}</td>
                <td>{person.nom}</td>
                <td>{person.dateNaissance}</td>
                <td>{person.sexe?"MALE":"FEMALE"}</td>
            </tr>
            )
      );
    }
}
