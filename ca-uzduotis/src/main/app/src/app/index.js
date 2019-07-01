import React from 'react';
import './App.css';
import Header from './component/header';
import { Container, Button } from 'react-bootstrap';
import Article from './component/article';
import ArticleList from './component/articleList';


function Index() {
    return (
        <Container>
            <div className="App">
                <Header />
                <main className="App--content ">
                    <ArticleList />
                    <Article />

                </main>
            </div>
        </Container>
    );
}

export default Index;
