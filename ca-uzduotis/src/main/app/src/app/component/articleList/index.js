import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import { Button, Modal, Form } from 'react-bootstrap';
import './index.css';


function ArticleList(props) {
    return (
        <div onClick={props.handleArticleListClick}>
            <h1>Article header</h1>
            <h6>2017-07-07</h6>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam suscipit metus vel enim amet.</p>
            <p>Author: Ksysia</p>
        </div>
    );
}

export default ArticleList;