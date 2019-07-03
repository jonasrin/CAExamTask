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
        this.HandleAddNewComment = props.HandleAddNewComment.bind(this);
        this.HandleAddNewAdminComment = props.HandleAddNewAdminComment.bind(this);
        this.state = {
            show: false,
            response: {},
            btnName: "Add Comment",
            commentRespUserName: props.commentRespUserName,
            isItAdmin: props.isItAdmin,
        };
    }

    handleClose() {
        this.setState({ show: false });
    }

    handleShow() {
        // this.setState({ show: !this.state.show });
        if (this.state.show) {
            if (this.state.isItAdmin) {
                this.setState({
                    btnName: "Add Author response",
                    show: !this.state.show
                });
            } else {
                this.setState({
                    btnName: "Add Comment",
                    show: !this.state.show
                });
            }
        } else {
            this.setState({
                btnName: 'Cancel add Comment',
                show: !this.state.show
            });
        }
    }

    render() {
        return (
            <div>
                <Button variant="primary" onClick={this.handleShow}>
                    {this.state.btnName}{/*{this.state.show ? 'Cancel add Comment' : 'Add Comment'} */}
                </Button>
                {this.state.show ? <AddCommentForm id={this.props.id} HandleAddNewComment={this.HandleAddNewComment} commentRespUserName={this.state.commentRespUserName} isItAdmin={this.state.isItAdmin} HandleAddNewAdminComment={this.HandleAddNewAdminComment} /> : null}
            </div>
        );
    }
}

class AddCommentForm extends React.Component {
    constructor(props) {
        super(props);
        this.HandleAddNewComment = props.HandleAddNewComment.bind(this);
        this.HandleAddNewAdminComment = props.HandleAddNewAdminComment.bind(this);
        this.state = {
            authorName: props.commentRespUserName,
            commentText: '',
            initialFormState: { authorName: '', commentText: '' },
            isItAdmin: props.isItAdmin,
        }
    };
    createComment = async event => {
        let response = {};
        if (this.state.isItAdmin) {
            response = await post(API_ENDPOINTS.addAdminComment + `${this.props.id}`, this.state);
            this.HandleAddNewAdminComment(response, this.props.id);
        } else {
            response = await post(API_ENDPOINTS.addcomment + `${this.props.id}`, this.state);
            this.HandleAddNewComment(response);
        }

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
                    <label>Comment text</label>
                    <input as="textarea" name="commentText" value={this.state.commentText} onChange={this.handleCommentInputChange} placeholder="Enter your comment" rows="3" />
                    <Button variant="primary" onClick={this.createComment}>
                        Save Changes
                </Button>
                </form>

            </div>)
    }
}
export default AddComment;
