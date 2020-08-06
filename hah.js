db.createUser({
  user: "aruix",
  pwd: "xingyudong",
  roles: [{ role: "userAdminAnyDatabases", db: "admin" }],
});

db.createUser({
  user: "xjtlu-book",
  pwd: "xjtlu-book",
  roles: [{ role: "userAdmin", db: "xjtlu-book" }],
});
db.grantRolesToUser('aruix', [{ role: 'root', db: 'admin' }])