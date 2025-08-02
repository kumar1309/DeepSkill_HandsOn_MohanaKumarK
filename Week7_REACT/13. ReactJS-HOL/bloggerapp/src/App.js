
import './App.css';
import React ,{useState} from 'react';
import { books, blogs, courses } from './data';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);
  const [showCourses, setShowCourses] = useState(true);
  return (
    <div className="App">
      <div className="toggle">
        <button onClick={()=>setShowCourses(!showCourses)}>Toggle Courses</button>
        <button onClick={()=>setShowBooks(!showBooks)}>Toggle Books</button>
        <button onClick={()=>setShowBlogs(!showBlogs)}>Toggle Blogs</button>
        
      </div>
      <div className="sections">
        {showCourses && <CourseDetails courses={courses} />}
        {showBooks && <BookDetails books={books} />}
        {showBlogs && <BlogDetails blogs={blogs} />}
      </div>
    </div>
   
  );
}

export default App;
