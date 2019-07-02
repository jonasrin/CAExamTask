import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import { Button, Modal, Form } from 'react-bootstrap';
import './index.css';
import { useFetch } from '../../utils/fetchHook';
import { API_DOMAIN, API_ENDPOINTS } from '../../utils/constants';
import { tsPropertySignature } from '@babel/types';
import ReactDOM from 'react-dom';
import Articleas from '../article';


function Item(props) {
    return (
        <div >
            {/* <div key={props.data.id} onClick={props.handleShowArticle(props.data.id)} > */}
            <div onClick={() => {
                props.handleShowArticle(props.data.id);
                props.handleArticleListClick(props.data);

            }
            }>
                <h1>{props.data.headline}</h1>
                <h6>{props.data.articleSaveDate}</h6>
                <p>{props.data.headlineText}</p>
                <p>{props.data.authorName}</p>
            </div>


        </div>
    )
}
class ArticleList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            showArticle: true,
            id: 0,
        };
        this.handleShowArticle = this.handleShowArticle.bind(this);
        this.handleArticleListClick = props.handleArticleListClick.bind(this);
        this.handleshowAddArticle = props.handleshowAddArticle.bind(this);

    }

    handleShowArticle(id) {
        // this.setState({ id: id });
        // this.setState.showArticle = !this.state.showArticle;
        // this.forceUpdate(this);
        // ShowArticleas(this.state.id);
    }

    render() {
        return (
            <div>
                {this.state.showArticle ?
                    <LoadData showArticle={this.state.showArticle} handleShowArticle={this.handleShowArticle} handleArticleListClick={this.handleArticleListClick} />
                    :
                    <Articleas id={this.state.id} />}


                {/* <LoadData handleShowArticle={this.handleShowArticle} showArticle={this.state.showArticle} />
                {/* <LoadData showArticle={this.state.showArticle} /> */}
            </div>
        );
    }
}

function ShowArticleas(props) {
    return (
        <Articleas id={2} />
    )
}

function LoadData(props) {
    let { loading, data, setData } = useFetch(API_ENDPOINTS.getArticles);
    let addArticle = article => {
        setData([...data, article])
    };

    return (

        <div >
            {loading ? (
                <div>Loading...</div>
            ) : (
                    data.map(
                        function (article) {
                            return (<Item data={article} handleShowArticle={props.handleShowArticle} handleArticleListClick={props.handleArticleListClick} />)
                        }
                    )
                )
            }

        </div>
    )
}


export default ArticleList;