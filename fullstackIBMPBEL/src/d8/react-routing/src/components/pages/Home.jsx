import { useNavigate } from "react-router-dom"
import resume from "../../assets/devdeep_singha_resume.pdf"

function Home() {
    const navigate = useNavigate()

    return (
        <section className="hero-grid">
            <article className="hero-card intro-card">
                <img
                    className="avatar"
                    src="https://avatars.githubusercontent.com/u/67728391?v=4"
                    alt="Devdeep Singha avatar"
                />

                <div className="copy-block">
                    <p className="section-label">Backend engineer in progress</p>
                    <h2>Building Scalable systems with Java, React, and cloud tools.</h2>
                    <p className="body-copy">
                        I am a B.Tech Computer Science student focused on backend engineering,
                        cloud systems, and database management.
                    </p>

                    <div className="action-row">
                        <a className="button" href={resume} target="_blank" rel="noreferrer">
                            View Resume
                        </a>
                        <button className="button" type="button" onClick={() => navigate("/about") }>
                            About Me
                        </button>
                        <button className="button" type="button" onClick={() => navigate("/contact") }>
                            Contact Me
                        </button>
                    </div>
                </div>
            </article>
        </section>
    )
}

export default Home