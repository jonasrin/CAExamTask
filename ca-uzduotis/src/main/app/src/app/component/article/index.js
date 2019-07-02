import React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './index.css';
import Comment from '../comment';
import { useFetch } from '../../utils/fetchHook';
import { API_DOMAIN, API_ENDPOINTS } from '../../utils/constants';
import { tsPropertySignature } from '@babel/types';



class Articleas extends React.Component {
    constructor(props) {
        super(props);
        this.state = ({
            props
            // id: props.id,
            // articleSaveDate: props.articleSaveDate,
            // articleText: props.articleText,
            // authorName: props.authorName,
            // // commentList: {props.commentList},
            // headline: props.headline,
            // headlineText: props.headlineText,
        });
    }
    // handleArticles() {
    //     const url = API_ENDPOINTS.getArticleById + `${this.state.id}`;

    //     this.setState = useFetch(url);
    //     let addArticle = article => {
    //         this.setData([...this.data, article])
    //     };
    // }
    render() {

        return (
            <div >
                <h1> fjakldjfkladjflkajfla</h1>
                {/* {this.loading ? (
                    <div>Loading...</div>
                ) : (
                        this.data.map(article => (
                            // <Item data={article} handleShowArticle={props.handleShowArticle}  */}
                <div>
                    <h1>{this.state.props.props.headline}</h1>
                    <h6>{this.props.props.articleSaveDate}</h6>
                    <p>{this.props.props.headlineText}</p>
                    <p>{this.props.props.articleText}</p>
                    <p>{this.props.props.authorName}</p>
                    <button>go back</button>
                    <Comment comments={this.props.props.commentViewList} id={this.props.props.id} />
                </div>
                {/* ))
                    )
                } */}

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