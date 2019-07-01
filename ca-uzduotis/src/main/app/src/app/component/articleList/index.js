import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import { Button, Modal, Form } from 'react-bootstrap';
import './index.css';
import { useFetch } from '../../utils/fetchHook';
import { API_DOMAIN, API_ENDPOINTS } from '../../utils/constants';

function Item(props) {
    return (
        <div onClick={props.handleArticleListClick}>
            <div>
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
            loading: '',
            data: '',
        };
    }
    handleGetArticles() {

        // 
    }

    render() {
        this.handleGetArticles();
        return (
            <LoadData />


        );
    }
}

function LoadData(props) {
    let { loading, data, setData } = useFetch(API_ENDPOINTS.getContacts);
    let addArticle = article => {
        setData([...data, article])
        alert(addArticle);
    };
    return (
        <div onClick={props.handleArticleListClick}>
            {loading ? (
                <div>Loading...</div>
            ) : (
                    data.map(article => (
                        <Item headline={data.headline} data={article} />
                    ))
                )}

        </div>
    )
}

export default ArticleList;