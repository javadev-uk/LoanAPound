This is a simple implementation of the loanAPound technical test for SagePeople.

I've gone for a plain java implementation, with no frameworks apart from JUnit to support some component testing.

I've implemented (most of) the data model and service layer, ignoring the view. I've concentrated on producing unit tests with an application context containg a couple of credit check agencies and a couple of loan applicants.

Given the 3 to 6 hour recommended time constraints I've left some interfaces unimplemented, but there should be enough here to exercise the main requirements.
