CREATE TABLE IF NOT EXISTS run(
    id INT NOT NULL,
    title VARCHAR(250) NOT NULL,
    started_on timestamp NOT NULL,
    completed_on timestamp NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(100) NOT NULL,
    version INT,
    PRIMARY KEY (id)
);