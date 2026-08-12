const education = [
    {
        title: "Bachelor of Technology - Computer Science",
        school: "Assam Down Town University",
        detail: "2023 - 2027",
    },
    {
        title: "High School",
        school: "Kendriya Vidyalaya, ONGC",
        detail: "2022",
    },
]

function About() {
    return (
        <section className="content-grid">
            <article className="content-card">
                <p className="section-label">Education</p>
                <h2>Academic background</h2>
                <div className="timeline">
                    {education.map((item) => (
                        <div key={item.title} className="timeline-item">
                            <div>
                                <h3>{item.title}</h3>
                                <p>{item.school}</p>
                            </div>
                            <span>{item.detail}</span>
                        </div>
                    ))}
                </div>
            </article>
        </section>
    )
}

export default About