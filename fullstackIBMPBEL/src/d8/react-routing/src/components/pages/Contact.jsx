const contactLinks = [
    {
        label: "Email",
        value: "devdeepkonsam1212@gmail.com",
        href: "mailto:devdeepkonsam1212@gmail.com",
    },
    {
        label: "Contact no.",
        value: "+91 6901665389",
        href: "tel:+916901665389",
    },
    {
        label: "LinkedIn",
        value: "linkedin.com/in/devdeepsingha",
        href: "https://www.linkedin.com/in/devdeepsingha",
    },
    {
        label: "GitHub",
        value: "github.com/devdeepkonsam",
        href: "https://github.com/devdeepkonsam",
    },
]

function Contact() {
    return (
        <section className="contact-wrap">
            <article className="contact-card">
                <p className="section-label">Contact</p>
                <h2>Let’s connect</h2>
                <p className="body-copy">
                    I’m available for collaborations, internships, and backend-focused projects.
                </p>

                <div className="contact-list">
                    {contactLinks.map((item) => (
                        <a key={item.label} className="contact-item" href={item.href} target={item.href.startsWith("http") ? "_blank" : undefined} rel={item.href.startsWith("http") ? "noreferrer" : undefined}>
                            <span>{item.label}</span>
                            <strong>{item.value}</strong>
                        </a>
                    ))}
                </div>
            </article>
        </section>
    )
}

export default Contact