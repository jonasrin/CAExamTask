import React from 'react';
import './App.css';
import Header from './component/header';
import { Container, Button } from 'react-bootstrap';
import Article from './component/article';
import ArticleList from './component/articleList';
import AddArticle from './component/addArticle';


class Index extends React.Component {
    constructor(props) {
        super(props);
        this.handleshowAddArticle = this.handleshowAddArticle.bind(this);
        this.handleArticleListClick = this.handleArticleListClick.bind(this);
        this.state = {
            showAddArticle: false,
            showArticleList: true,
            showArticle: false,
        };

    }
    handleshowAddArticle(props) {
        this.setState({
            showAddArticle: !this.state.showAddArticle,
            showArticleList: !this.state.showArticleList,
            showArticle: !this.state.showArticle,
        });

    }
    handleArticleListClick() {
        this.setState({
            showAddArticle: false,
            showArticleList: false,
            showArticle: true,
        });
    }
    render() {
        return (
            <Container>
                <div className="App">
                    <Header handleshowAddArticle={this.handleshowAddArticle} />
                    <main className="App--content ">
                        {this.state.showArticleList ? <ArticleList handleArticleListClick={this.handleArticleListClick} /> : null}
                        {this.state.showAddArticle ? <AddArticle /> : null}
                        {this.state.showArticle ? <Article /> : null}
                    </main>
                </div>
            </Container>
        );
    }
}

export default Index;
