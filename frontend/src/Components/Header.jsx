import React from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';

function Header() {
    


    return (
      <div>
        <Navbar bg="dark" variant="dark">
          <Container>
            <Navbar.Brand >Event Management App</Navbar.Brand>
          </Container>
        </Navbar>
      </div>
    );
}

export default Header;


