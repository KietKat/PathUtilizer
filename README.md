# PathUtilizer
Used Language: Java
Core implementation: Directed Graph, Dijkstra’s Shortest Path algorithm.
Mechanic: 
Given a file that contains all the possible links between two nodes, where the nodes are noted by number addresses, along with their distance. Dijkstra algorithm is a greedy algorithm, as it prioritizes the choice of the path with the shortest distance. In this case, where the distance is all positive, the algorithm gurantees the shortest path between one node to the other ones.
Example:
In the example, the user wants to find the shortest paths from the stations (marked as yellow nodes) to the customers (marked as white), and stations must not be connected. The text file includes all directed edges between the nodes and stations, along with the distances. The algorithm takes in the file and returns the instruction showing how to connect them.
