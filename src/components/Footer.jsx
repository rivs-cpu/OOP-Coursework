import { Box, Typography } from '@mui/material';

function Footer() {
  return (
    <Box
      sx={{
        backgroundColor: 'black',
        color: 'white',
        textAlign: 'center',
        py: 2,
        mt: 4,
      }}
    >
      <Typography variant="body2">
        © 2024 Real-Time Ticketing System
      </Typography>
    </Box>
  );
}

export default Footer
