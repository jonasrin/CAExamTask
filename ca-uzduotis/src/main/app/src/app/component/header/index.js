import React, { Component, useState } from 'react';
import { render } from 'react-dom';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import { Jumbotron, Button, Navbar, Nav, NavDropdown, Form, FormControl } from 'react-bootstrap';
import LoginModal from '../modal/login';
import AddArticle from '../addArticle';




class Header extends React.Component {
    constructor(props) {
        super(props);
        this.handleshowAddArticle = props.handleshowAddArticle.bind(this);
        this.state = {
            showAddArticle: props.showAddArticle,
            showArticleList: props.showArticleList,
            showArticle: props.showArticle,
        };

    }

    render() {
        return (
            <div>
                <button onClick={() => this.handleshowAddArticle()}>Add Article</button></div >

            // <header className={Jumbotron}>

            //     <Navbar bg="light" expand="lg">
            //         <Navbar.Brand href="#home">Kshysia blog</Navbar.Brand>
            //         <Navbar.Toggle aria-controls="basic-navbar-nav" />
            //         <Navbar.Collapse id="basic-navbar-nav">
            //             <Nav className="mr-auto">
            //                 <LoginModal />

            //             </Nav>
            //         </Navbar.Collapse>
            //     </Navbar>
            // </header >
        );
    }
}

export default Header;