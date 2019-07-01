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

function AddCommentForm(props) {
    const createComment = async event => {
        event.preventDefault();
        // if (!contact.value || !contact.icon || !contact.link) return;
        // props.initialFormState = [{ ...this.state.authorName, ...this.state.commentText }];
        props.response = await post(API_ENDPOINTS.addArticle, this.state);
    };
    const handleAuthorInputChange = event => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
    const handleCommentInputChange = event => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
    return (
        <div>
            <Form>
                <Form.Label>Name</Form.Label>
                <Form.Control type="text" name="authorName" value={props.authorName} onChange={handleAuthorInputChange} placeholder="Enter your name" />
                <Form.Label>Name</Form.Label>
                <Form.Control type="text" name="commentText" value={props.commentText} onChange={handleCommentInputChange} placeholder="Enter your name" rows="3" />
                <Button variant="primary" onClick={createComment}>
                    Save Changes
                </Button>
            </Form>

        </div>)

}
export default AddArticle;
