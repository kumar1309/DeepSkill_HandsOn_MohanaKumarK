import React from 'react';
function BlogDetails({blogs}){
    return (
        <div className="blog-details">
            <h1>Blog Details</h1>
            <ul>
                {blogs.map((blog) => (
                    <div key={blog.id}>
                        <h3>{blog.title}</h3>
                        <h4>{blog.author}</h4>
                        <p>{blog.content}</p>
                    </div>
                ))}
            </ul>
        </div>
    )
}
export default BlogDetails;