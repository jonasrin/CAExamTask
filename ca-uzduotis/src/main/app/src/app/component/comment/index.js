import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import AddComment from '../addComment';



function Comment(props) {
    const commentResp = '';
    return (
        <div>
            <AddComment comment={commentResp} id={props.id} />
            <ul>
                {props.comments.map(comment => <ListComment data={comment} />)}
            </ul>
        </div>
    );
}

function ListComment(props) {
    return (
        <li>
            <p>{props.data.authorName}</p>
            <p>{props.data.commentText}</p>
            {/* <button>Answer</button> */}
            <p>{props.data.adminComment}</p>}
        </li>
    )
}

export default Comment;