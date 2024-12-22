/**
 * @param {number[]} heights
 * @param {number[][]} queries
 * @return {number[]}
 */
var leftmostBuildingQueries = function(heights, queries) {
    const n = heights.length;
    const queryCount = queries.length;

    // Initialize the result array with -1 (default for no meeting place)
    const result = Array(queryCount).fill(-1);

    // Queue to hold deferred queries grouped by the larger index
    const deferredQueries = Array(n).fill().map(() => []);

    // MinPriorityQueue for processing deferred queries efficiently
    const priorityQueue = new MinPriorityQueue();

    // Step 1: Handle direct cases
    queries.forEach(([aliceStart, bobStart], queryIndex) => {
        if (aliceStart === bobStart) {
            // Alice and Bob are already in the same building
            result[queryIndex] = aliceStart;
        } else if (aliceStart < bobStart && heights[aliceStart] < heights[bobStart]) {
            // Alice can directly move to Bob's building
            result[queryIndex] = bobStart;
        } else if (aliceStart > bobStart && heights[aliceStart] > heights[bobStart]) {
            // Bob can directly move to Alice's building
            result[queryIndex] = aliceStart;
        } else {
            // Defer queries where direct movement isn't possible
            const maxHeight = Math.max(heights[aliceStart], heights[bobStart]);
            const maxIndex = Math.max(aliceStart, bobStart);
            deferredQueries[maxIndex].push([maxHeight, queryIndex]);
        }
    });

    // Step 2: Process buildings in order
    for (let currentBuilding = 0; currentBuilding < n; ++currentBuilding) {
        // Process queries in the priority queue for buildings shorter than the current one
        while (!priorityQueue.isEmpty() && priorityQueue.front().element[0] < heights[currentBuilding]) {
            const { element } = priorityQueue.dequeue();
            result[element[1]] = currentBuilding; // Assign current building index as the answer
        }

        // Add deferred queries for the current building to the priority queue
        deferredQueries[currentBuilding].forEach(query =>
            priorityQueue.enqueue(query, query[0])
        );
    }

    return result;
};