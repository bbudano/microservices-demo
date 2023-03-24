import axios from 'axios';
import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';

axios.defaults.withCredentials = true;

function App() {

  const [user, setUser] = useState(null);

  const getUserProfile = () => {
    axios.get('/api/v1/users/profile')
    .then(response => setUser(response.data))
    .catch(error => setUser(null));
  }

  const logout = () => {
    axios.post('/logout')
    .then(response => setUser(null))
  }

  useEffect(() => {
    getUserProfile();
  }, [])

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        {user && <div>
          <p>{`Email: ${user.email}`}</p>
          <p>{`Role: ${user.role}`}</p>
          <button onClick={logout}>Logout</button>
        </div>}
      </header>
    </div>
  );
}

export default App;
