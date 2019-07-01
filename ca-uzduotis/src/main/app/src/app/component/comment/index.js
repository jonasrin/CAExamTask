import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import AddComment from '../addComment';



function Comment() {
    const commentResp = '';
    return (
        <div>
            <AddComment comment={commentResp} />
            <ul>
                <li>
                    <p>Comment author</p>
                    <p>komentaras</p>
                    <button>Answer</button>
                    <p>Admin answer to comment</p>
                </li>
                <li>
                    <p>Comment author</p>
                    <p>komentaras</p>
                    <button>Answer</button>
                    <p>Admin answer to comment</p>
                </li>
                <li>
                    <p>Comment author</p>
                    <p>komentaras</p>
                    <button>Answer</button>
                    <p>Admin answer to comment</p>
                </li>
                <li>
                    <p>Comment author</p>
                    <p>komentaras</p>
                    <button>Answer</button>
                    <p>Admin answer to comment</p>
                </li>
            </ul>


        </div>
    );
}

export default Comment;