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
        this.handleArticleShowListClick = props.handleArticleShowListClick.bind(this);
        this.handleLogin = props.handleLogin.bind(this);
        this.state = {
            showAddArticle: props.showAddArticle,
            showArticleList: props.showArticleList,
            showArticle: props.showArticle,
            isitadmin: false,
        };
    }

    render() {
        return (
            <div>
                <Navbar bg="light" expand="lg">
                    <Navbar.Brand onClick={() => this.handleArticleShowListClick()}>Kshysia blog</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="mr-auto">
                            {/* <Button onClick={
                                () => {
                                    const admin = this.handleLogin();
                                    this.setState({ isitadmin: admin });
                                }


                            }
                            >Login</Button>
                            {this.state.isitadmin ? */}
                            <Button onClick={() => this.handleshowAddArticle()}>Add Article</Button>
                            {/* : null} */}
                        </Nav>
                    </Navbar.Collapse>
                </Navbar>
            </div >
        );
    }
}

export default Header;