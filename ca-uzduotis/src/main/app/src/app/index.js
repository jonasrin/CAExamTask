import React from 'react';
import './App.css';
import Header from './component/header';
import { Container, Button } from 'react-bootstrap';
import Articleas from './component/article';
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
            articleId: {},
        };

    }
    handleshowAddArticle(props) {
        this.setState({
            showAddArticle: !this.state.showAddArticle,
        });
        if (!this.state.showAddArticle) {
            this.setState({
                showArticleList: false,
                showArticle: false,
            });
        } else {
            this.setState({
                showArticleList: true,
                showArticle: false,
            });
        }
    }
    handleArticleListClick(props) {
        this.setState({
            showAddArticle: false,
            showArticleList: false,
            showArticle: true,
            articleId: props,
        });
        // return (
        //     <Articleas propsas={props} />
        // )
    }
    render() {
        return (
            <Container>
                <div className="App">
                    <Header handleshowAddArticle={this.handleshowAddArticle} />
                    <main className="App--content ">
                        {this.state.showArticleList ? <ArticleList handleArticleListClick={this.handleArticleListClick} handleshowAddArticle={this.handleshowAddArticle} /> : null}
                        {this.state.showAddArticle ? <AddArticle /> : null}
                        {this.state.showArticle ? <Articleas props={this.state.articleId} /> : null}
                    </main>
                </div>
            </Container>
        );
    }
}

export default Index;
