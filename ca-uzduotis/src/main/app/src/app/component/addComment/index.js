import React, { Component, useState } from 'react';
import { render } from 'react-dom';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import { Button, Modal, Form } from 'react-bootstrap';
import { post } from '../../utils/post';
import { API_ENDPOINTS } from '../../utils/constants';
class AddComment extends React.Component {
    constructor(props, context) {
        super(props, context);

        this.handleShow = this.handleShow.bind(this);
        this.handleClose = this.handleClose.bind(this);
        this.state = {
            show: false,
            response: {},
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
            <div>
                <Button variant="primary" onClick={this.handleShow}>{this.state.show ? 'Cancel add Comment' : 'Add Comment'}</Button>
                {this.state.show ? <AddCommentForm id={this.props.id} /> : null}
            </div>
        );
    }
}

class AddCommentForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            authorName: '',
            commentText: '',
            initialFormState: { authorName: '', commentText: '' },
        }
    };
    createComment = async event => {
        event.preventDefault();
        this.setState.initialFormState = [{ ...this.state.authorName, ...this.state.commentText }];
        this.setState.response = await post(API_ENDPOINTS.addcomment + `${this.props.id}`, this.state);
        this.forceUpdate();
    };
    handleAuthorInputChange = event => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
    handleCommentInputChange = event => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
    render() {
        this.setState.initialFormState = this.state;
        return (
            <div>
                <form>
                    <label>Name</label>
                    <input type="text" name="authorName" value={this.state.authorName} onChange={this.handleAuthorInputChange} placeholder="Enter your name" />
                    <label>Name</label>
                    <input type="textarea" name="commentText" value={this.state.commentText} onChange={this.handleCommentInputChange} placeholder="Enter your name" rows="3" />
                    <Button variant="primary" onClick={this.createComment}>
                        Save Changes
                </Button>
                </form>

            </div>)
    }
}
export default AddComment;
