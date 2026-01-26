(Assignment 3)



## A. Project Overview

### Purpose of API
The purpose of this project is to build a Java-based, REST-like application for managing playlists that contain songs and podcasts.  
The application allows users to view playlist contents, add media to playlists, and remove media from playlists using a real relational database.

### Summary of Entities and Their Relationships
The main entities in the system are:

**Media** – abstract base entity representing playable content

**Song** and **Podcast** – concrete subclasses of Media

**Playlist** – collection of media items

**playlist_media** – junction table implementing a many-to-many relationship

A playlist can contain multiple media items, and a media item can belong to multiple playlists.

### OOP Design Overview
The application follows an object-oriented design with abstraction, inheritance, and polymorphism.  
A layered architecture is used to separate responsibilities between models, services, repositories, and the application entry point.

---

## B. OOP Design Documentation

### Abstract Class and Subclasses
**Media** is an abstract class that defines common fields such as **id**, **title**, and **duration**.

**Song** and **Podcast** extend **Media** and provide concrete implementations.

### Interfaces and Implemented Methods
The **Playable** interface defines behavior for playable content.

Media subclasses implement methods such as **play()** and **getType()**.

### Composition / Aggregation
**PlaylistService** uses (`has-a`) **PlaylistRepository**.

**MediaService** uses (`has-a`) **MediaRepository**.

### Polymorphism Examples

Media objects are handled through the **Media** type while executing subclass-specific behavior.

Songs and podcasts are treated uniformly when added to or removed from playlists.

### UML Diagram
A UML class diagram is provided showing:

inheritance between **Media**, **Song**, and **Podcast**

service-to-repository dependencies
---

## C. Database Description

### Schema, Constraints, Foreign Keys
The database schema consists of three tables:

**media**

**playlist**

**playlist_media**

Foreign keys in **playlist_media** reference **media(id)** and **playlist(id)** to enforce relational integrity.

### Sample SQL Inserts
Example:
```sql
INSERT INTO playlist (name) VALUES ('Make my day with fire');

INSERT INTO media (title, duration, type)
VALUES ('Tuka Donka', 150, 'song');

INSERT INTO playlist_media (playlist_id, media_id)
VALUES (1, 1);
```
## D. Controller
Summary of CRUD Operations (Example Requests / Responses)
```
**Create (Add media):**

**Input: 1**

**Enter media id to add: 8**

**Output: Media added.**
```
```
**Read (View playlist):**

**PLAYLIST = "Make my day with fire"**

**MEDIA:**

**5 - "Tuka Donka" (song, 150 secs)**
```
```
**Delete (Remove media):**

**Input: 2**

**Enter media id to delete: 8**

**Output: Media removed.**
```
```
Exit:

Input: exit
Output: Exit. No changes made.
```
## E. Instructions to Compile and Run
```
javac Main.java

java Main
```

## F. Screenshots
![Imagealt](https://github.com/AldairRonin/Assignment3/blob/main/docs/add_media.png?raw=true)

![imagealt](https://github.com/AldairRonin/Assignment3/blob/main/docs/delete_media.png?raw=true)

**Custom Exceptions

The project defines a custom exception hierarchy located in the 'exception' package:

-InvalidInputException

-DuplicateResourceException

-ResourceNotFoundException

-DatabaseOperationException

## G. Reflection Section

***What I learned***

 - How to design a layered Java application
  
-  How to use JDBC to interact with a relational database
  
-  How to implement many-to-many relationships

***Challenges Faces***

- Managing database IDs correctly

- Handling user input safely

- Ensuring clean separation between layers

***Benefits of JDBC and Multi-Layer Design**

- JDBC provides direct control over database operations

- Multi-layer design improves maintainability and readability

- The application is easier to extend and debug

