import './App.css';
import EventList from './Components/EventList';
import Header from './Components/Header';
import Footer from './Components/Footer';

function App() {
  return (
    <div className="App">
      <Header/>
      <div className='pt-3 pb-5'>
      <EventList />
      </div>
      <Footer/>
    </div>
  );
}

export default App;
