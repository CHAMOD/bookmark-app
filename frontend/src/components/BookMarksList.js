import React, { useState, useEffect } from 'react';
import { Link} from 'react-router-dom';
import { Container, Table } from 'react-bootstrap';
import BookmarkAPI from '../services/BookmarkService'
import { Button} from 'react-bootstrap';


const BookMarksList = () => {
  const [bookmarkInfo, setInfo] = useState([]);

  useEffect(() => {


    BookmarkAPI.getAllBookMarks().then(result => {
      if (result.status === 200) {
        setInfo(result.data);

      }
    })

  }, {});

  function deleteBookmarks (id) {
		BookmarkAPI.deleteBookmark(id).then(result => {

			
			if (result && result.status === 200) {
        BookmarkAPI.getAllBookMarks().then(result => {
          if (result.status === 200) {
            setInfo(result.data);
    
          }
        })

			} else {
			
			}

		}
		)

	};

  return (


    <Container>

      {JSON.stringify(bookmarkInfo) !== JSON.stringify([]) &&
        <div>
          <Table striped bordered hover variant="light">
            <thead>
              <tr>
                <th>Name</th>
                <th>URL</th>
                <th>Description</th>
                <th>Status</th>
                <th>expiry date</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {bookmarkInfo.map(t => (
                <tr key={t.id}>
                  <td>{t.name}</td>
                  <td>{t.url}</td>
                  <td>{t.description}</td>
                  <td>{t.status}</td>
                  <td>{t.status === 1 ? "ACTIVE" :"DEACTIVATE"}</td>
                  <td>{t.expiryDate}</td>
                  <td>
 
                    <Link 
                
                    to={{
                      pathname: "/editBookmark/"+t.id,
                      state: { data:t }
                    }}

                    >
                    <Button size="sm" variant="success" type="button" >
                       Edit
                    </Button>
                     </Link>
                  
                    <Button size="sm" variant="danger" type="button" onClick={() => deleteBookmarks(t.id)}>
                      Delete
                    </Button></td>

                </tr>
              ))
              }
              {!bookmarkInfo.length && 'No bookmarks are found.'}
            </tbody>
          </Table>
        </div>
      }
    </Container>
  );
};

export default BookMarksList;