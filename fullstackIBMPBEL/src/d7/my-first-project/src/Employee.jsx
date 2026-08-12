function Employee({ name, department, salary, age, experience }) {
	return (
		<section className="employee-card">
			<h2 className="employee-title">Employee Card</h2>
			<div className="employee-row">
				<span className="employee-label">Name :</span>
				<span className="employee-value">{name}</span>
			</div>
			<div className="employee-row">
				<span className="employee-label">Department:</span>
				<span className="employee-value">{department}</span>
			</div>
			<div className="employee-row">
				<span className="employee-label">Salary:</span>
				<span className="employee-value">{salary}</span>
			</div>
			<div className="employee-row">
				<span className="employee-label">Age:</span>
				<span className="employee-value">{age}</span>
			</div>
			<div className="employee-row">
				<span className="employee-label">Experience:</span>
				<span className="employee-value">{experience}</span>
			</div>
		</section>
	)
}

export default Employee
