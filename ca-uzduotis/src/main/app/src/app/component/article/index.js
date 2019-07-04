import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import Comment from '../comment';
import { useFetch } from '../../utils/fetchHook';
import { API_DOMAIN, API_ENDPOINTS } from '../../utils/constants';
import { tsPropertySignature } from '@babel/types';
import { Button } from 'react-bootstrap';
import AddArticle from '../addArticle';
import { delRest } from '../../utils/delRest';



class Articleas extends React.Component {
    constructor(props) {
        super(props);
        this.state = ({
            props,
            isitadmin: false,
        });
        this.handleArticleShowListClick = props.handleArticleShowListClick.bind(this);
        this.handleArticleEditClick = props.handleArticleEditClick.bind(this);
        this.handleDeleteArticle = this.handleDeleteArticle.bind(this);
        // this.handleLogin = props.handleLogin.bind(this);
        // this.handleMainLogin = this.handleMainLogin.bind(this);
    }
    handleDeleteArticle() {

        delRest(API_ENDPOINTS.deleteArticle + this.state.props.props.id);
        alert('straipsnis buvo ištrintas');
        this.handleArticleShowListClick();
    }
    // handleMainLogin() {
    //     const admin = this.handleLogin();
    //     this.setState({
    //         isitadmin: admin,
    //     })
    // }
    render() {

        return (
            <div >
                <div>
                    {/* {this.state.isItAdmin ?
                        <div> */}
                    <Button onClick={() => this.handleArticleEditClick(this.state.props.props)} isEditArticle={false}>edit</Button>
                    <Button onClick={this.handleDeleteArticle}>delete</Button>
                    {/* </div>
                        : null} */}

                    <h1>{this.state.props.props.headline}</h1>
                    <h6>{this.props.props.articleSaveDate}</h6>
                    <p>{this.props.props.headlineText}</p>
                    <p>{this.props.props.articleText}</p>
                    <p>{this.props.props.authorName}</p>
                    <Button onClick={this.handleArticleShowListClick}>go back</Button>
                    <Comment comments={this.props.props.commentViewList} id={this.props.props.id} />
                </div>
            </div>
        );
    }
}
// function ShowArticle(props) {
//     const url = API_ENDPOINTS.getArticleById + `${props.id}`;

//     let { loading, data, setData } = useFetch(url);
//     let addArticle = article => {
//         setData([...data, article])
//     };
//     return (
//         <div>
//             {loading ? (
//                 <div>Loading...</div>
//             ) : (
//                     data.map(
//                         article => (
//                             <div>
//                                 <h1>{article.headline}</h1>
//                                 <p>{article.articleText}</p>
//                                 <p>{article.authorName}</p>
//                                 <Comment />
//                             </div>
//                         )
//                     )
//                 )
//             }
//         </div>
//     );
// }


export default Articleas;