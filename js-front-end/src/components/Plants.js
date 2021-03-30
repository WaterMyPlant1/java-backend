import axios from "axios";
import React, { useState } from "react";

export default function Plants(props) {
  const [plant, setPlant] = useState(props.plant);
  console.log(plant);
  const handleChange = (e) =>
    setPlant({
      ...plant,
      [e.target.name]: e.target.value,
    });

  const submit = (e) => {
    axios.patch(``);
  };

  return (
    <div>
      <form onSubmit={submit}>
        <label htmlFor="nickname">nickName</label>
        <input
          type="text"
          name="nickname"
          id="nickname"
          value={plant.nickname}
          onChange={handleChange}
        />

        <label htmlFor="species">species</label>
        <input
          type="text"
          name="species"
          id="species"
          value={plant.species}
          onChange={handleChange}
        />

        <label htmlFor="h2oFrequency">h2oFrequency</label>
        <input
          type="text"
          name="h2oFrequency"
          id="h2oFrequency"
          value={plant.h2oFrequency}
          onChange={handleChange}
        />
        <button type="submit">submit</button>
      </form>
    </div>
  );
}
