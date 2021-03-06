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

    Can set token to local storage from this end point and route to protected routes

### Response
    {
        "access_token": "a4e391e6-f88e-4e9f-8948-53290b08a2f7",
        "token_type": "bearer",
        "scope": "read trust write"
    }

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

## Get User Info
### Request

`GET https://watermyplant-tt7.herokuapp.com/users/getuserinfo`

    axiosWithAuth()
      .get("/users/getuserinfo")
      .then((res) => {
        setUserData(res.data);
      })
      .catch((err) => {
        debugger;
      });

### Response

    res.data
    {
        "userid": 4,
        "username": "admin",
        "phoneNumber": "786-898-3348",
        "useremails": [
            {
                "useremailid": 9,
                "useremail": "admin@email.local"
            },
            {
                "useremailid": 10,
                "useremail": "admin@mymail.local"
            }
        ],
        "roles": [
            {
                "role": {
                    "roleid": 1,
                    "name": "ADMIN"
                }
            },
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            },
            {
                "role": {
                    "roleid": 3,
                    "name": "DATA"
                }
            }
        ],
        "plants": [
                {
                    "plantId": 5,
                    "nickname": "Plant1",
                    "species": "Species1",
                    "h2oFrequency": 3,
                    "img": "https://images.unsplash.com/photo-1484509025075-64c8133991bf?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDR8fHBsYW50c3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
                    "baseDate": 0,
                },
                {
                    "plantId": 6,
                    "nickname": "Plant2",
                    "species": "Species2",
                    "h2oFrequency": 4,
                    "img": "https://images.unsplash.com/photo-1484509025075-64c8133991bf?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDR8fHBsYW50c3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
                    "baseDate": 0,
                },
                {
                    "plantId": 7,
                    "nickname": "Plant3",
                    "species": "Species3",
                    "h2oFrequency": 5,
                    "img": "https://images.unsplash.com/photo-1484509025075-64c8133991bf?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDR8fHBsYW50c3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
                    "baseDate": 0,
                },
                {
                    "plantId": 8,
                    "nickname": "Plant4",
                    "species": "Species4",
                    "h2oFrequency": 6,
                    "img": "https://images.unsplash.com/photo-1484509025075-64c8133991bf?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDR8fHBsYW50c3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
                    "baseDate": 0,                
                }
        ]
    }

## Edit User Username and Password

### Request

`PATCH https://watermyplant-tt7.herokuapp.com/users/user/{userid}`

### Response

    HttpStatus.OK

## Get list of Plants By UserId

### Request

`GET https://watermyplant-tt7.herokuapp.com/plants/{userId}`

`GET https://watermyplant-tt7.herokuapp.com/plants/4`

### Response
    res.data
    Array of plants:
    [
        {
            "plantId": 5,
            "nickname": "Plant1",
            "species": "Species1",
            "h2oFrequency": 3,
            "img": "https://images.unsplash.com/photo-1484509025075-64c8133991bf?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDR8fHBsYW50c3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
            "baseDate": 0,
            "user": {
                "userid": 4,
                "username": "admin",
                "phoneNumber": "786-898-3348",
                "useremails": [
                    {
                        "useremailid": 9,
                        "useremail": "admin@email.local"
                    },
                    {
                        "useremailid": 10,
                        "useremail": "admin@mymail.local"
                    }
                ],
                "roles": [
                    {
                        "role": {
                            "roleid": 1,
                            "name": "ADMIN"
                        }
                    },
                    {
                        "role": {
                            "roleid": 2,
                            "name": "USER"
                        }
                    },
                    {
                        "role": {
                            "roleid": 3,
                            "name": "DATA"
                        }
                    }
                ]
            }
        },
        ....
    ]

## Create New Plant

### Request

`POST https://watermyplant-tt7.herokuapp.com/plants/newplant`

### Response
    
    {
        "plantId": 26,
        "nickname": "plant50505",
        "species": "Species50505",
        "h2oFrequency": 6,
        "img": "https://images.unsplash.com/photo-1505066211281-ed125c006f4c?ixid=MXwxMjA3fDB8MHxzZWFyY2h8Mzl8fHBsYW50c3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
        "baseDate": 0,
        "user": {
            "userid": 4,
            "username": "admin",
            "phoneNumber": "786-898-3348",
            "useremails": [
                {
                    "useremailid": 9,
                    "useremail": "admin@email.local"
                },
                {
                    "useremailid": 10,
                    "useremail": "admin@mymail.local"
                }
            ],
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                },
                {
                    "role": {
                        "roleid": 2,
                        "name": "USER"
                    }
                },
                {
                    "role": {
                        "roleid": 3,
                        "name": "DATA"
                    }
                }
            ]
        }
    }

## Edit Plant by ID

### Request

`PATCH https://watermyplant-tt7.herokuapp.com/plants/plant/{plantId}`

### Response
    {
        "plantId": 5,
        "nickname": "Plant1",
        "species": "Species377",
        "h2oFrequency": 6,
        "img": "https://images.unsplash.com/photo-1488353816557-87cd574cea04?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NjR8fHBsYW50c3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
        "baseDate": 0,
        "user": {
            "userid": 4,
            "username": "admin",
            "phoneNumber": "786-898-3348",
            "useremails": [
                {
                    "useremailid": 6,
                    "useremail": "admin@email.local"
                },
                {
                    "useremailid": 7,
                    "useremail": "admin@mymail.local"
                }
            ],
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                },
                {
                    "role": {
                        "roleid": 2,
                        "name": "USER"
                    }
                },
                {
                    "role": {
                        "roleid": 3,
                        "name": "DATA"
                    }
                }
            ]
        }
    }

## Delete Plant By ID

### Request

`DELETE https://watermyplant-tt7.herokuapp.com/plants/plant/{plantId}`

### Response
    staus OK

