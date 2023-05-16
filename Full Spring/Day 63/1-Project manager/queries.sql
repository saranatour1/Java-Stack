use project_maneger_schema;

SELECT projects.id, projects.title, leader.first_name, projects.due_date ,projects.leader_id FROM projects 
INNER JOIN users AS leader ON projects.leader_id = leader.id
LEFT JOIN memebers_projects ON projects.id = memebers_projects.project_id 
INNER JOIN users ON (projects.leader_id = users.id OR memebers_projects.joinee_id = users.id) WHERE users.id = 1;






SELECT projects.id, projects.title, projects.descreption, projects.due_date, users.first_name
FROM projects
INNER JOIN users ON projects.leader_id = users.id

WHERE users.id = 2 ;

SELECT projects.id, projects.title, users.first_name, projects.due_date, projects.leader_id
FROM projects
LEFT JOIN memebers_projects ON projects.id = memebers_projects.project_id
INNER JOIN users AS leader ON projects.leader_id = leader.id
INNER JOIN users ON memebers_projects.joinee_id = users.id
WHERE users.id = 1;



SELECT projects.id, projects.title, users.first_name, projects.due_date ,projects.leader_id FROM projects 
LEFT JOIN memebers_projects ON projects.id = memebers_projects.project_id
 INNER JOIN users ON (projects.leader_id = users.id OR memebers_projects.joinee_id = users.id) WHERE users.id = 1;

SELECT projects.id, projects.title, users.first_name, projects.due_date
FROM projects
inner join memebers_projects on memebers_projects.project_id = projects.id
inner join users on  memebers_projects.joinee_id = users.id 
where projects.id not in (select memebers_projects.project_id from memebers_projects where memebers_projects.joinee_id =2); 

SELECT projects.id, projects.title ,users.first_name, Date(projects.due_date) as due_date FROM projects 
LEFT JOIN memebers_projects ON projects.id = memebers_projects.project_id
INNER JOIN users ON memebers_projects.joinee_id = users.id
WHERE projects.id NOT IN (
   SELECT memebers_projects.project_id 
   FROM memebers_projects
   WHERE  users.id = 1);
   
   

SELECT p.id, p.title, users.first_name, p.due_date FROM projects p
inner join users on p.leader_id = users.id 
WHERE p.leader_id <> :id
AND :id NOT IN (
  SELECT joinee_id FROM memebers_projects mp
  WHERE mp.project_id = p.id
);
