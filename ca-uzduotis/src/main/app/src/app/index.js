import React from 'react';
import logo from '../logo.svg';
import './App.css';
import Header from './component/header';
import {Container, Button} from 'react-bootstrap';


function Index() {
    return (
        <Container>
            <div className="App">
                <Header/>
                <main className="App--content ">
                    <Button>mygelis</Button>
                </main>
            </div>
        </Container>
    );
}

export default Index;
