import React, { Component, useState } from 'react';
import { render } from 'react-dom';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import { Button, Modal, Form } from 'react-bootstrap';
import { post } from '../../utils/post';
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
                <AddCommentForm props={this.state} />
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
        // if (!contact.value || !contact.icon || !contact.link) return;
        // props.initialFormState = [{ ...this.state.authorName, ...this.state.commentText }];
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
export default AddArticle;
