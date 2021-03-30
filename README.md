# Water My Plant App Backend - Java

# REST API

The REST API for Water My Plant.

## Set-Up For Front End

### Axios With Auth
    export const axiosWithAuth = () => {
    const token = window.localStorage.getItem("token");
    
        return axios.create({
            headers: {
                Authorization: `Bearer ${token}`,
            },
            baseURL: "https://watermyplant-tt7.herokuapp.com",
        });
    };

### Login Axios Call

    const [credentials, setCredentials] = useState({ username: "", password: "" });
	const login = (e) => {
		e.preventDefault();
		axios
			.post(
				"https://watermyplant-tt7.herokuapp.com/login",
				`grant_type=password&username=${credentials.username}&password=${credentials.password}`,
				{
					headers: {
						// btoa is converting our client id/client secret into base64
						Authorization: `Basic ${btoa("lambda-client:lambda-secret")}`,
						"Content-Type": "application/x-www-form-urlencoded",
					},
				},
			)
			.then((res) => {
				console.log(res.data);
				localStorage.setItem("token", res.data.access_token);
				props.history.push("/userinfo");
			});
	};

## Sign Up New User

### Request

`POST https://watermyplant-tt7.herokuapp.com/createnewuser`

    Automatically logs in user - can route directly to protected route

## Login

### Request
`POST https://watermyplant-tt7.herokuapp.com/login`

## Dummy LogIn
`username: admin password: password`

### Response


    {
    access_token: "9624bba7-52bf-492f-821d-53663a2e2f43",
    token_type: "bearer", scope: "read write trust"
    }

    {
        phoneNumber: "786-898-3348" (String)
        plants: [Object] (1) (Array)
        primaryemail: null
        roles: [{role: {roleid: 1, name: "ADMIN"}}, {role: {roleid: 2, name: "USER"}}, {role: {roleid: 3, name: "DATA"}}] (3)
        useremails: [{useremailid: 6, useremail: "admin@email.local"}, {useremailid: 7, useremail: "admin@mymail.local"}] (2)
        userid: 4 (interger)
        username: "admin" (String)
    }

## Get list of Plants By UserId

### Request

`GET https://watermyplant-tt7.herokuapp.com/plants/{userId}`

`GET https://watermyplant-tt7.herokuapp.com/plants/4`
### Response
    res.data
    Array of plants:
    {
        h2oFrequency: "06/30/2002" (String)
        nickname: "Plant1" (String)
        plantId: 5
        species: "Species1" (String)
        user: {userid: 4, username: "admin", primaryemail: null, phoneNumber: "786-898-3348", useremails: [{useremailid: 6, useremail: "admin@email.local"}, {useremailid: 7, useremail: "admin@mymail.local"}], …}
    }

