import React, { useContext } from 'react'
import { Navbar, Nav, NavItem, NavbarBrand } from 'react-bootstrap';
import { Link, withRouter } from 'react-router-dom';
import { LoginContext } from "./loginContext";


const NavigationBar = () => {

	const loginContext = useContext(LoginContext);
	return (


		<div>
			<Navbar color="light" expand="md" bg="dark" variant="dark">
				<NavbarBrand>Bookmark Application</NavbarBrand>
				<Nav className="mr-auto" navbar>
					{loginContext.role === 'USER' && loginContext.isLoggedIn ?
						<>
							<NavItem>
								<Link to={"bookmarks"} className="nav-link">View Transaction History</Link>
							</NavItem>
							<NavItem>
								<Link to={"/"} className="nav-link">Dashboard</Link>
							</NavItem>
						</>
						:
						<>
						</>
					}
				</Nav>

				<Nav className="ml-auto" navbar>
					{loginContext.isLoggedIn ?
						<NavItem right="true">
							<Link exact="true" to={"logout"} className="nav-link">Logout</Link>
						</NavItem> :
						<NavItem className="nav navbar-nav navbar-right">
							<Link exact="true" to={"login"} className="nav-link">Login</Link>
						</NavItem>
					}
				</Nav>
			</Navbar>
		</div>

	);


}

export default withRouter(NavigationBar);