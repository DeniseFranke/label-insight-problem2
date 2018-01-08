# Problem 2 - Animation
A collection of particles is contained in a linear chamber. They all have the same speed, but some are headed toward the right and others are headed toward the left. These
particles can pass through each other without disturbing the motion of the particles, so all the particles will leave the chamber relatively quickly.

You will be given the initial conditions by a string 'init' containing at each position an 'L'
for a leftward moving particle, an 'R' for a rightward moving particle, or a '.' for an empty
location. 'init' shows all the positions in the chamber. Initially, no location in the chamber
contains two particles passing through each other.

We would like an animation of the particles as they move. At each unit of time, we want
a string showing occupied locations with an 'X' and unoccupied locations with a '.'.

Create a method 'animate' that takes a positive integer 'speed' and a string 'init' giving
the initial conditions. The speed is the number of positions each particle moves in one
unit of time. The method will return an array of strings in which each successive element
shows the occupied locations at each time step. The first element of the return should show the occupied locations at the initial instant (at time = 0) in the 'X', '.' format. The
last element in the return should show the empty chamber at the first time that it
becomes empty.

Again, imagine that the method you write will be called thousands of times for varying
initial conditions with size ranging from 0 to 50, and also imagine the case when init is
several hundred thousand locations in size (though with speed > size / 20 or so).  Try to
handle both of these cases efficiently in your implementation.

particle
 - direction = L R .
distance unit 
t = time unit
s = speed = particle's u/t
    
## Table of contents
- [Prerequisites](#prerequisites)
- [Quick start](#quick-start)
- [Status](#status)
- [Bugs and feature requests](#bugs-and-feature-requests)
- [Documentation](#documentation)
- [Contributing](#contributing)
- [Versions](#versions)
- [Creator](#creator)
- [Copyright and license](#copyright-and-license)

## Prerequisites
- Java 8
- Maven 3.5.0
- Junit 4.12
- Junit.Jupiter 5.0.2
- SpringBoot 1.5.9.RELEASE

## Quick start
 1. Get the Repo: 
		```git clone git@github.com:DeniseFranke/label-insight-problem2.git```
 2. Import into your IDE - Menu **File –> Import –> Maven –> Existing Maven Projects**
        ```Browse to your source code location
        Click **Finish** button to finish the importing```
 3. Check the versions in the pom.xml, 
		```Update version of to match your environment or update your environment.```
 4. Run the example with Junit: 
        ```mvn test```
   
## Status
[![Slack]](https://denisefranke/slack.com/#status)

## Bugs and feature requests
Find a bug or would like to request a new feature? 
Please first read the [issue guidelines](CONTRIBUTING.md#using-the-issue-tracker) 
Note:  Normally I would point to the issues page in the github repo here and recommend searching the for existing and closed issues.  If your problem or idea has not already been addressed, 
[please open a new issue](link to the github project's issue page normally would go here ).

## Documentation
Documentation consists of this README.md, the CONTRIBUTING.md and all files in this archive's /documents folder.

## Contributing
Please read through the project's [contributing guidelines](https://github.com/DeniseFranke/simulator/CONTRIBUTING.md). 
It provides direction for opening issues, coding standards, and notes on development.
Moreover, if your pull request contains any code changes, please include relevant unit tests.

## Versions
For transparency into the release cycle and in striving to maintain backward compatibility, 
this site is maintained under [the Semantic Versioning guidelines](http://semver.org/).
Normally I would put a github releases page reference here with a discussion about changelogs and where to find major release announcements for each major release version of the utility.   Usually I put these on a slack channel so continuous integration tool (jenkins, etc) can update it automatically via a hook. 

## Creator
**Denise Franke**
- [twitter](https://twitter.com/charmedlife000)
- [github](https://github.com/DeniseFranke)
- [linkedin](https://www.linkedin.com/in/denisefranke)

## Copyright and license
Code and documentation released under [MIT License] (hhttps://github.com/DeniseFranke/label-insight-problem1/blob/master/LICENSE) and Copyright (c) 2018 by @DeniseFranke

Docs released under the Creative Commons License and Copyright (c) 2018 by @DeniseFranke 
