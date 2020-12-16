import React, { Component } from 'react'
import UserService from '../services/UserService'

class ListUsers extends Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        }

    }

     componentDidMount(){
        UserService.getUsers().then((res) => {
            this.setState({users: res.data});
        });
     }

    render() {
        return (
           <div>
                <h2 className="text-center">Employees List</h2>
                <tbody>
                    {
                        this.state.users.map(
                            user =>
                            <tr key = {user.id}>
                                <td> { user.id} </td>
                                <td> { user.userName} </td>
                                <td> { user.password} </td>
                                <td> { user.email} </td>
                                <button>x</button>
                            </tr>
                        )
                    }
                </tbody>

           </div>
        );
    }
}

export default ListUsers;