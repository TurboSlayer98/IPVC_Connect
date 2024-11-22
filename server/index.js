const express = require('express');
const cors = require('cors');
const { Pool } = require('pg');
require('dotenv').config();

const app = express();
const port = process.env.PORT || 3000;

// Middleware
app.use(cors());
app.use(express.json());

// Database configuration
const pool = new Pool({
    user: process.env.DB_USER,
    host: process.env.DB_HOST,
    database: process.env.DB_NAME,
    password: process.env.DB_PASSWORD,
    port: process.env.DB_PORT,
});

// Test database connection
pool.query('SELECT NOW()', (err, res) => {
    if (err) {
        console.error('Database connection error:', err);
    } else {
        console.log('Database connected successfully');
    }
});

// Schools endpoints
app.get('/schools', async (req, res) => {
    try {
        const result = await pool.query('SELECT * FROM public.schools');
        res.json(result.rows);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

app.get('/schools/:id', async (req, res) => {
    try {
        const { id } = req.params;
        const result = await pool.query('SELECT * FROM public.schools WHERE id = $1', [id]);
        if (result.rows.length === 0) {
            return res.status(404).json({ message: 'School not found' });
        }
        res.json(result.rows[0]);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

// Courses endpoints
app.get('/courses', async (req, res) => {
    try {
        const result = await pool.query('SELECT * FROM public.courses');
        res.json(result.rows);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

app.get('/courses/:id', async (req, res) => {
    try {
        const { id } = req.params;
        const result = await pool.query('SELECT * FROM public.courses WHERE id = $1', [id]);
        if (result.rows.length === 0) {
            return res.status(404).json({ message: 'Course not found' });
        }
        res.json(result.rows[0]);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

// Companies endpoints
app.get('/companies', async (req, res) => {
    try {
        const result = await pool.query('SELECT * FROM public.companies');
        res.json(result.rows);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

app.get('/companies/:id', async (req, res) => {
    try {
        const { id } = req.params;
        const result = await pool.query('SELECT * FROM public.companies WHERE id = $1', [id]);
        if (result.rows.length === 0) {
            return res.status(404).json({ message: 'Company not found' });
        }
        res.json(result.rows[0]);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

// Comments endpoints
app.get('/companies/:companyId/comments', async (req, res) => {
    try {
        const { companyId } = req.params;
        const result = await pool.query('SELECT * FROM public.comments WHERE company_id = $1', [companyId]);
        res.json(result.rows);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

app.post('/companies/:companyId/comments', async (req, res) => {
    try {
        const { companyId } = req.params;
        const { text } = req.body;
        const result = await pool.query(
            'INSERT INTO public.comments (company_id, text, created_at) VALUES ($1, $2, NOW()) RETURNING *',
            [companyId, text]
        );
        res.status(201).json(result.rows[0]);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

// Add this endpoint to get courses by school ID
app.get('/schools/:id/courses', async (req, res) => {
    try {
        const { id } = req.params;
        const result = await pool.query('SELECT * FROM public.courses WHERE school_id = $1', [id]);
        res.json(result.rows);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

app.listen(port, () => {
    console.log(`Server running on port ${port}`);
}); 