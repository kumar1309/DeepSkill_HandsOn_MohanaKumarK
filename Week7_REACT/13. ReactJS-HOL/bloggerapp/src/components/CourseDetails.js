import React from 'react';
function CourseDetails({courses}){
    return (
        <div className='course-details'>
            <h1>Course Details</h1>
            <ul>
                {courses.map((course) => (
                    <div key={course.id}>
                        <h3>{course.cname}</h3>
                        <h4>{course.date}</h4>
                    </div>
                ))}
            </ul>
        </div>
    )
}
export default CourseDetails;
