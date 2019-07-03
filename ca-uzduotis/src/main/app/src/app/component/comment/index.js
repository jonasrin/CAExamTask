import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import AddComment from '../addComment';
import { Button } from 'react-bootstrap';



class Comment extends React.Component {
    constructor(props) {
        super(props);
        this.state = props;
        this.HandleAddNewComment = this.HandleAddNewComment.bind(this);
        this.HandleAddNewAdminComment = this.HandleAddNewAdminComment.bind(this);
    }
    HandleAddNewComment(props) {
        this.state.comments.push(props);
        this.forceUpdate();
    }
    HandleAddNewAdminComment(props, id) {
        let myCom = this.state.comments.find(comment => comment.id === id);
        myCom.adminComment = props;
        this.state.comments.push(myCom);

        // this.setState(prevState =>
        //     (

        //         {
        //         comments: {
        //             ...prevState.comments,
        //             adminComments: {
        //                 prevState.adminComments,
        //                  props },
        //         }
        //     }
        // )
        // );

        //  [].adminComment.push(props);
        this.forceUpdate();
    }
    render() {


        const commentRespUserName = 'Ksysia'; //todo pakeisti i admin useri    
        return (
            <div>
                {/* commentRespUserName={commentRespUserName} */}
                <AddComment id={this.state.id} isItAdmin={false} HandleAddNewComment={this.HandleAddNewComment} HandleAddNewAdminComment={this.HandleAddNewAdminComment} />
                <ul>
                    {this.state.comments.map(comment => <ListComment data={comment} commentRespUserName={commentRespUserName} HandleAddNewComment={this.HandleAddNewComment} HandleAddNewAdminComment={this.HandleAddNewAdminComment} />)}
                </ul>
            </div>
        );
    }
}



function ListComment(props) {
    const isItAdmin = props.commentRespUserName;
    return (
        <li>
            <p>Komentatoriaus vardas: {props.data.authorName}</p>
            <p>komentaras: {props.data.commentText}</p>
            {props.data.adminComment !== null ?
                <div>
                    <p>Vartotojo vardas: {props.data.adminComment.authorName}</p>
                    <p>atsakymas: {props.data.adminComment.commentText}</p>
                </div>
                :
                <div>
                    {
                        props.commentRespUserName !== '' ?
                            <AddComment commentRespUserName={props.commentRespUserName} id={props.data.id} isItAdmin={true} HandleAddNewComment={props.HandleAddNewComment} HandleAddNewAdminComment={props.HandleAddNewAdminComment} />
                            :
                            null
                    }
                </div>
            }
            <hr />
        </li>

    )
}

export default Comment;