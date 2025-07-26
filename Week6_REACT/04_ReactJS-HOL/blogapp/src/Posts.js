import React, { Component } from 'react';
import Post from './Post';
class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false
        };
    }
    loadPosts = () => {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                this.setState({ posts: data });
            })
            .catch(error => {
                console.error('Error fetching posts:', error);
                this.setState({ hasError: true });
            });
    }
    componentDidMount() {
        this.loadPosts();
    }
    componentDidCatch(error, info) {
        this.setState({ hasError: true });
        alert("Something went wrong in Posts component!");
    }
    render() {
        const { posts } = this.state;
        return (
            <div>
                <h2>Blog Posts</h2>
                {posts.map(post => (
                    <Post key={post.id} title={post.title} body={post.body} />
                ))}

            </div>
        )
    }
}
export default Posts;