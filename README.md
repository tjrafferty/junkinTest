jukin-thingamajig
=================

Please follow these instructions very carefully. Reading comprehension and attention to detail counts!

## Basic
Don't ask me why, but the CTO loves to periodically check the top rated (in stars) 'groovy' repositories on Github, 
and view its latest commit – all on one simple page – with maybe 20 entries. 

It just has to be really simple and work, but it would be good to impress the boss. You'll be taking over this project 
and it may become more sophisticated, so maintainability should be a key attribute of any solution. Don't worry about 
it working in any environment other than 'development'.

We had a junior developer working on it, and he built something that isn't quite ready and just needs "a little more work". 

try:
http://localhost:8080/jukin-thingamajig/github/list/repos

Suggested areas to improve:
* when the application starts, the default URL should go to the main page (github/list/repos)
* page load time must be less than 10 seconds. A good solution is less than 7 seconds, and a great one is less than 5 seconds.
* if you have time, making the UI prettier would be nice

## Advanced
The CTO wants to involve the engineering team in finding interesting Groovy projects. Of the top 20 projects in Github,
he wants the Engineering team to be able to see them and vote on the projects. The voting mechanism should be a simple like / dislike vote
with a textarea for the engineer to write why the repo was liked or disliked. This should be displayed as a comment stream attached to
each repo. The CTO also wants to see this implemented as a ReST API.

Your solution should fit into the Grails framework and employ Grails best practices. Use the embedded h2 database (already setup in the project)
for the persistence layer. You'll be taking over this project and it may become more sophisticated, so maintainability should be a 
key attribute of any solution. Don't worry about it working in any environment other than 'development'.

There is a basic set of functional tests that must pass in order to submit your answer. You are encouraged to add your own set of tests
as you feel are necessary for proper code coverage. To run the functional tests, make sure you are in the project root and run:
```./grailsw test-app functional:```

## General Instructions
For all versions of this test, after you have unzipped the archive, initialize this as a new git repository:

```
git init
git add .
git commit
```

As you are working, commit work as you normally would in your development workflow. When you are finished with the test,
be sure to make your final commit, and export the code using

```git archive --format=zip -o <your-name>.zip HEAD```

Please fill in "<your-name>" with your name (E.G. john-smith.zip). Once the archive exported,
email it back to have the solution evaluated.

Email me at kris.shinn@jukinmedia.com if you get stuck or need hints, happy to clarify.

Thanks!

PS. It is advisable to use IntelliJ IDEA Ultimate Edition, which has great support for Grails, and a 30 day free trial.
