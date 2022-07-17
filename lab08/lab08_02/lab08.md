# Lab 8 - API Testing

### a) Console output for your practice GET requests:

```
GET https://pokeapi.co/api/v2/pokemon/snorlax200
636 ms
Network

agent: "Cloud Agent"

addresses: {…}

    tls: {…}

Request Headers
User-Agent: PostmanRuntime/7.29.2
Accept: */*
Cache-Control: no-cache
Postman-Token: 663f53ec-7703-4446-b2c7-df55ede31eb1
Host: pokeapi.co
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
Response Headers
Date: Sun, 17 Jul 2022 02:47:25 GMT
Content-Type: application/json; charset=utf-8
Transfer-Encoding: chunked
Connection: keep-alive
alt-svc: h3=":443"; ma=86400, h3-29=":443"; ma=86400
access-control-allow-origin: *
Cache-Control: public, max-age=86400, s-maxage=86400
etag: W/"4a052-cRsK7VsOY9lEz85BPZ9ZAR5hK0s"
function-execution-id: h8evq3mlo14m
strict-transport-security: max-age=31556926
x-cloud-trace-context: c67c08379b494ef807aa720d5985fd69
x-country-code: US
x-orig-accept-language: pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7
x-powered-by: Express
x-served-by: cache-iad-kiad7000055-IAD
x-cache: HIT
x-cache-hits: 1
x-timer: S1657926201.293954,VS0,VE1
vary: Accept-Encoding,cookie,need-authorization, x-fh-requested-host, accept-encoding
CF-Cache-Status: HIT
Age: 12771
Expect-CT: max-age=604800, report-uri="https://report-uri.cloudflare.com/cdn-cgi/beacon/expect-ct"
Report-To: {"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v3?s=n0n9LYKYendilg4fRMrvo%2FRPN76Csf7ZV%2F1va0VarfMWTJ2iaVuhGXKjTN%2FIN1UxBrKRezyyAOVLBI8vUr2jrRsvjvWCg2gLc9OoVZIpAAzYpqnm1On3H4XbpLQz"}],"group":"cf-nel","max_age":604800}
NEL: {"success_fraction":0,"report_to":"cf-nel","max_age":604800}
Server: cloudflare
CF-RAY: 72bfa71feb0c59b0-IAD
Content-Encoding: br
```

### b) API Tests distributed from the outlined endpoints

**TC1:** Test for the response time to be within a specified range (200ms) 

Endpoint request: `https://pokeapi.co/api/v2/ability/1`

```
pm.test("Response time is less than 200ms", () => {
  pm.expect(pm.response.responseTime).to.be.below(200);
});
```

**TC2:** Test the types of the response

Endpoint request `https://pokeapi.co/api/v2/ability/1`

```
const jsonData = pm.response.json();
pm.test("Test data type of the response", () => {
    pm.expect(jsonData).to.be.an("object");
    pm.expect(jsonData.id).to.be.a("number");
    pm.expect(jsonData.name).to.be.a("string");
    pm.expect(jsonData.is_main_series).to.be.a("boolean");
    pm.expect(jsonData.generation).to.be.an("object");
    pm.expect(jsonData.names).to.be.an("array");
    pm.expect(jsonData.effect_entries).to.be.an("array");
    pm.expect(jsonData.effect_changes).to.be.an("array");
    pm.expect(jsonData.flavor_text_entries).to.be.an("array");
    pm.expect(jsonData.pokemon).to.be.an("array");
});
```

**TC3:** Test whether the body contains a string

Endpoint request: `https://pokeapi.co/api/v2/ability/1`

```
pm.test("Body matches string", function () {
    pm.expect(pm.response.text()).to.include("Has no effect in battle.");
});
```

**TC4:** Test whether an array contains a specific description

Endpoint request: `https://pokeapi.co/api/v2/characteristic/1`

```
const jsonData = pm.response.json();
pm.test("Test array properties", () => {
    const descriptionValue = jsonData.descriptions.find
        (m => m.description === "먹는 것을 제일 좋아함");
    pm.expect(descriptionValue).to.be.an("object");
});
```

**TC5:** Test whether the location name matches

Endpoint request `https://pokeapi.co/api/v2/location/1`

```
pm.test("Name matches string", function () {
    pm.expect(pm.response.text()).to.include("canalave-city-area");
});
```

**TC6:** Test for a response header having a paticular value

Endpoint request `https://pokeapi.co/api/v2/location/1`

```
pm.test("Content-Type header is application/json", () => {
  pm.expect(pm.response.headers.get('Content-Type'))
  .to.eql('application/json; charset=utf-8');
});
```

### c) Tests for creating, patching, and deleting a resource

Testing creating a resource

Request: `https://jsonplaceholder.typicode.com/posts`

```
pm.test("Response body contains", () => {
    const responseJson = pm.response.json();
    pm.expect(responseJson.id).to.eql(101);
    pm.expect(responseJson.title).to.eql("foo");
    pm.expect(responseJson.body).to.eql("bar");
    pm.expect(responseJson.userId).to.eql(1);
});
```

Request body:
```
{
    "id": 101,
    "title": "foo",
    "body": "bar",
    "userId": 1
}
```

Testing patching a resource  

Request: `https://jsonplaceholder.typicode.com/posts/1`

```
pm.test("Response body contains", () => {
    const responseJson = pm.response.json();
    pm.expect(responseJson.userId).to.eql(1);
    pm.expect(responseJson.id).to.eql(1);
    pm.expect(responseJson.title).to.eql("foo");
    pm.expect(responseJson.body).to.eql("...");
});
```

Request body:
```
{
    "userId": 1,
    "id": 1,
    "title": "foo",
    "body": "..."
}
```

Testing deleting a resource 

Request: `https://jsonplaceholder.typicode.com/posts/1`

```
pm.test("Empty response body", () => {
    var responseJson = pm.response.json();
    pm.expect(responseJson).to.not.be.undefined;
});
```



