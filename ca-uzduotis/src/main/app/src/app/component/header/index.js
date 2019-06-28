import React, { Component } from 'react';
import { render } from 'react-dom';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import { Jumbotron, Button, Navbar, Nav, NavDropdown, Form, FormControl } from 'react-bootstrap';
import CommentModal from '../modal/addComment';
import LoginModal from '../modal/login';
import AddArticle from '../modal/addArticle';



function Header() {
    return (
        <header className={Jumbotron}>
            <Navbar bg="light" expand="lg">
                <Navbar.Brand href="#home">Kshysia blog</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <LoginModal />
                        <AddArticle />
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        </header>
    );
}

export default Header;