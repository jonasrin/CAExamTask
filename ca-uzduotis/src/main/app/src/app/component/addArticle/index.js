import React, { Component, useState } from 'react';
import { render } from 'react-dom';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import { Button, Modal, Form } from 'react-bootstrap';
import { post } from '../../utils/post';
import { put } from '../../utils/put';
import { API_ENDPOINTS } from '../../utils/constants';
class AddArticle extends React.Component {
    constructor(props, context) {
        super(props, context);

        this.handleShow = this.handleShow.bind(this);
        this.handleClose = this.handleClose.bind(this);
        this.state = {
            show: false,
            articleSaveDate: '',
            articleText: '',
            authorName: '',
            commentList: {},
            headline: '',
            headlineText: '',
            isEditArticle: this.props.isEditArticle,
            props
        };
    }
    handleClose() {
        this.setState({ show: false });
    }
    handleShow() {
        this.setState({ show: !this.state.show });

    }
    render() {
        return (
            <div >
                {this.isEditArticle ? <EditCommentForm props={this.state} /> : <AddCommentForm props={this.state} />}


            </div>
        );
    }
}

class AddCommentForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {};
        this.handleAuthorInputChange = this.handleAuthorInputChange.bind(this);

    }
    createComment = async event => {
        event.preventDefault();
        this.state.response = await post(API_ENDPOINTS.addArticle, this.state);
    };
    handleAuthorInputChange = event => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
    handleCommentInputChange = event => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
    handleHeadlineChange = event => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
    render() {
        if (this.props !== null) {

        }

        return (
            <div>
                <Form>
                    <Form.Label>Author Name</Form.Label>
                    <Form.Control type="text" name="authorName" value={this.state.authorName} onChange={this.handleAuthorInputChange} placeholder="Enter your name" />
                    <Form.Label>Headline</Form.Label>
                    <Form.Control type="text" name="headline" value={this.state.headline} onChange={this.handleHeadlineChange} placeholder="Enter headline of your article" />
                    <Form.Label>Article text</Form.Label>
                    <Form.Control as="textarea" name="articleText" value={this.state.articleText} onChange={this.handleCommentInputChange} placeholder="Enter your article" rows="3" />
                    <Button variant="primary" onClick={this.createComment}>
                        Save Changes
                </Button>
                </Form>

            </div>)
    }

}

class EditCommentForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = ({
            editableArticle: props.props.props.props
        });
        this.handleAuthorInputChange = this.handleAuthorInputChange.bind(this);

    }
    createComment = async event => {
        this.state.response = await put(API_ENDPOINTS.editArticle, this.state.editableArticle, this.state.editableArticle.id);
    };
    handleAuthorInputChange = event => {
        this.setState({
            editableArticle: {
                id: this.state.editableArticle.id,
                authorName: event.target.value,
                articleText: this.state.editableArticle.articleText,
                headline: this.state.editableArticle.headline,
            }
        });
    }
    handleCommentInputChange = event => {
        this.setState({
            editableArticle: {
                id: this.state.editableArticle.id,
                articleText: event.target.value,
                authorName: this.state.editableArticle.authorName,
                headline: this.state.editableArticle.headline,
            }
        });
    }
    handleHeadlineChange = event => {
        this.setState({
            editableArticle: {
                id: this.state.editableArticle.id,
                headline: event.target.value,
                authorName: this.state.editableArticle.authorName,
                articleText: this.state.editableArticle.articleText,
            }
        });
    }
    render() {
        if (this.props !== null) {

        }
        // let editableArticle = this.props.props.props.props;
        return (
            <div>
                <Form>
                    <Form.Label>Author Name</Form.Label>
                    <Form.Control type="text" name="authorName" value={this.state.editableArticle.authorName} onChange={this.handleAuthorInputChange} placeholder="Enter your name" />
                    <Form.Label>Headline</Form.Label>
                    <Form.Control type="text" name="headline" value={this.state.editableArticle.headline} onChange={this.handleHeadlineChange} placeholder="Enter headline of your article" />
                    <Form.Label>Article text</Form.Label>
                    <Form.Control as="textarea" name="articleText" value={this.state.editableArticle.articleText} onChange={this.handleCommentInputChange} placeholder="Enter your article" rows="3" />
                    <Button variant="primary" onClick={this.createComment}>
                        Save Changes
                </Button>
                </Form>

            </div>)
    }

}
export default AddArticle;
