import logo from './logo.svg';
import { PersonsComponent } from './components/Persons';
import React, { useState } from 'react';

import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        Cette application cherche des personnes
      </header>
      <table>
        <thead>
          <tr className='headers'>
            <td className="indiv-header">Prénom</td>
            <td className="indiv-header">Nom</td>
            <td className="indiv-header">Date de naissance</td>
            <td className="indiv-header">Sexe</td>
          </tr>
        </thead>
        <tbody>
          <PersonsComponent></PersonsComponent>
        </tbody>
      </table>
    </div>
  );
}

export default App;
