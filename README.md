## Resilience 4J Circuit Breaker [Fault Tolerance]

## Key Features

State Management: The circuit breaker operates in three states:

I) CLOSED: All requests are allowed; the system is functioning normally.
II) OPEN: Requests are blocked after a certain failure threshold is reached, preventing further calls to the failing service.
III) HALF_OPEN: A limited number of requests are allowed to check if the service has recovered.

Failure Detection: It monitors the success and failure rates of calls to external services, allowing it to switch states based on predefined thresholds.

Fallback Mechanism: When the circuit breaker is open, it can return a predefined fallback response instead of failing outright, which can improve user experience and system reliability.



## Real-time Scenario

User Experience

During Backend Issues:
If the backend service is experiencing problems, users making requests to /consumingServiceEndpoint will receive the response from the fallback URI.

The fallback response can include a message indicating that the service is temporarily unavailable, which helps manage user expectations.

Once the Backend Recovers:

After the backend service stabilizes, the circuit breaker will automatically transition back to the CLOSED state after the HALF_OPEN state is successfully tested.

Users will then be able to make requests to the original endpoint, and those requests will be routed to the backend service as normal.
