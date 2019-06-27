import React from 'react';
import './index.css';
import { Jumbotron, Button, Navbar, Nav, NavDropdown, Form, FormControl } from 'react-bootstrap';



function Header() {
    return(
      <header className={Jumbotron}>
          <Navbar bg="light" expand="lg">
              <Navbar.Brand href="#home">Kshysia blogas</Navbar.Brand>
              <Navbar.Toggle aria-controls="basic-navbar-nav" />
              <Navbar.Collapse id="basic-navbar-nav">
                  <Nav className="mr-auto">
                      <Nav.Link href="#home">Adminstrator</Nav.Link>

                  </Nav>
                  {/*<Form inline>*/}
                      {/*<FormControl type="text" placeholder="Search" className="mr-sm-2" />*/}
                      {/*<Button variant="outline-success">Search</Button>*/}
                  {/*</Form>*/}
              </Navbar.Collapse>
          </Navbar>
      </header>
    );
}

export default Header;